package by.lightsup.socialstat.entity;

public class LargeUserWithCoeff {

	private LargeUserVO user;
	private double coeff;

	public LargeUserVO getUser() {
		return user;
	}

	public void setUser(LargeUserVO user) {
		this.user = user;
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coeff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LargeUserWithCoeff other = (LargeUserWithCoeff) obj;
		if (Double.doubleToLongBits(coeff) != Double.doubleToLongBits(other.coeff))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
