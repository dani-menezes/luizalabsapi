package com.luizalabs.api.common;


/**
 * Common methods of a {@link CommonBean}
 * @author danielmenezes
 */
public abstract class AbstractCommonBean implements CommonBean {
	
	/** Generated Serial UID Version. */
	private static final long serialVersionUID = -7771510679277600034L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CommonBean other = (CommonBean) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(getId())) {
			return false;
		}
		return true;
	}
}
