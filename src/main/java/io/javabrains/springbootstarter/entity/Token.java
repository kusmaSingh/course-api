package io.javabrains.springbootstarter.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Kusma Singh
 * @time 12:00:36 PM
 * @date 06-Feb-2018
 */
@Entity
@Table(name="TOKEN")
public class Token implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6853967005619511674L;
	private Long tokenId;
	private String token;
	private Date generatedDateAndTime;
	private Date expiryDate;
    private User user;
    /**
     * 
     */

	public Token() {
		super();
	}
	/** 
	 * 
	 * @param tokenId
	 * @param token
	 * @param generatedDateAndTime
	 * @param expiryDate
	 * @param user
	 */

	public Token(Long tokenId, String token, Date generatedDateAndTime, Date expiryDate, User user) {
		super();
		this.tokenId = tokenId;
		this.token = token;
		this.generatedDateAndTime = generatedDateAndTime;
		this.expiryDate = expiryDate;
		this.user = user;
	}

	/**
	 * @return the tokenId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TOKEN_ID")
	public Long getTokenId() {
		return tokenId;
	}
/* 
 * @param tokenId
 *            the tokenId to set
 * 
 */
	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}

	/**
	 * @return the token
	 */
	@Column(name = "TOKEN")
	public String getToken() {
		return token;
	}
	/* 
	 * @param token
	 *            the token to set
	 * 
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return the generatedDateAndTimec
	 */
	@Column(name = "CREATED_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getGeneratedDateAndTime() {
		return generatedDateAndTime;
	}
	/* 
	 * @param generatedDateAndTime
	 *            the generatedDateAndTime to set
	 * 
	 */
	public void setGeneratedDateAndTime(Date generatedDateAndTime) {
		this.generatedDateAndTime = generatedDateAndTime;
	}
	
	
	@Column(name = "EXPIRY_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getExpiryDate() {
		return expiryDate;
	}
	/* 
	 * @param expiryDate
	 *            the expiryDate to set
	 * 
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the user
	 */
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_USER_TOKEN_ID_N"), nullable = false)
	public User getUser() {
		return user;
	}
	/* 
	 * @param user
	 *            the user to set
	 * 
	 */

	public void setUser(User user) {
		this.user = user;
	}
	


    @SuppressWarnings("unused")
	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public void updateToken(final String token) {
        this.token = token;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (expiryDate == null) {
            if (other.expiryDate != null) {
                return false;
            }
        } else if (!expiryDate.equals(other.expiryDate)) {
            return false;
        }
        if (token == null) {
            if (other.token != null) {
                return false;
            }
        } else if (!token.equals(other.token)) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Token [String=").append(token).append("]").append("[Expires").append(expiryDate).append("]");
        return builder.toString();
    }
	
}

