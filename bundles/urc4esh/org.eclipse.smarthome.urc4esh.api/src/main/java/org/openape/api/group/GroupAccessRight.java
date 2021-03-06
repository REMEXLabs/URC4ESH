package org.openape.api.group;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class defines the access rights of one group for one resource. There
 * exists four access rights. The read right means, that users, which are member
 * of the group with the id {@link GroupAccessRight#groupId} are allowed to read
 * the resource with the id {@link GroupAccessRight#resourceId}. The read update
 * means, that users, which are member of the group with the id
 * {@link GroupAccessRight#groupId} are allowed to update the resource with the
 * id {@link GroupAccessRight#resourceId}. The read delete means, that users,
 * which are member of the group with the id {@link GroupAccessRight#groupId}
 * are allowed to delete the resource with the id
 * {@link GroupAccessRight#resourceId}. The read change rights right means, that
 * users, which are member of the group with the id
 * {@link GroupAccessRight#groupId} are allowed to change the access rights of
 * this group and all other groups for the resource with the id
 * {@link GroupAccessRight#resourceId}.
 *
 * This class is thread safe.
 *
 * @author Tobias Ableitner
 *
 */
public class GroupAccessRight {

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // attributes
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    /**
     * Id of the group, for which the access rights count.
     */
	// TODO test if it can be annotated with @JSONIgnore
    private String groupId;

    /**
     * Read right. True means, that the group members are allowed to read the
     * concept and false that not.
     */
    private boolean readRight;

    /**
     * Update right. True means, that the group members are allowed to update
     * the concept and false that not.
     */
    private boolean updateRight;

    /**
     * Delete right. True means, that the group members are allowed to delete
     * the concept and false that not.
     */
    private boolean deleteRight;

    /**
     * Change rights right. True means, that the group members are allowed to
     * change the access rights for the concept and false that not.
     */
    private boolean changeRightsRight;

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // constructors
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    /**
     * Default constructor used by json.
     */
    public GroupAccessRight() {

    }

    /**
     * Create a GroupAccessRight.
     *
     * @param groupId
     *            id of the group. The groupId must not be null or empty.
     * @param resourceId
     *            id of the resource. The resource id must not be null or empty.
     * @param readRight
     *            true if the group is allowed to read the concept and false if
     *            not
     * @param updateRight
     *            true if the group is allowed to update the concept and false
     *            if not
     * @param deleteRight
     *            true if the group is allowed to delete the concept and false
     *            if not
     * @param changeRightsRight
     *            true if the group is allowed to change the access rights for
     *            the concept and false if not
     */
    public GroupAccessRight(final String groupId, final boolean readRight,
            final boolean updateRight, final boolean deleteRight, final boolean changeRightsRight) {
        this.setGroupId(groupId);
        this.setReadRight(readRight);
        this.setUpdateRight(updateRight);
        this.setDeleteRight(deleteRight);
        this.setChangeRightsRight(changeRightsRight);
    }

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // getters and setters
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    /**
     * The id of the group, for which the group access rights are defined.
     *
     * @return id of the group
     */
    public String getGroupId() {
        return this.groupId;
    }

    /**
     * Getter for the change rights right.
     *
     * @return true if the group members are allowed to change the access rights
     *         for the resource and false if not.
     */
    @JsonProperty(value="changeRightsRight")
    public boolean hasChangeRightsRight() {
        return this.changeRightsRight;
    }

    /**
     * Getter for the delete right.
     *
     * @return true if the group members are allowed to delete the resource and
     *         false if not.
     */
    @JsonProperty(value="deleteRight")
    public boolean hasDeleteRight() {
        return this.deleteRight;
    }

    /**
     * Getter for the read right.
     *
     * @return true if the group members are allowed to read the resource and
     *         false if not.
     */
    @JsonProperty(value="readRight")
    public boolean hasReadRight() {
        return this.readRight;
    }

    /**
     * Getter for the update right.
     *
     * @return true if the group members are allowed to update the resource and
     *         false if not.
     */
    @JsonProperty(value="updateRight")
    public boolean hasUpdateRight() {
        return this.updateRight;
    }

    /**
     * Setter for the change rights right.
     *
     * @param changeRightsRight
     *            true if the group members should have change rights right and
     *            false if not
     */
    public void setChangeRightsRight(final boolean changeRightsRight) {
        this.changeRightsRight = changeRightsRight;
    }

    /**
     * Setter for the delete right.
     *
     * @param deleteRight
     *            true if the group members should have delete right and false
     *            if not
     */
    public void setDeleteRight(final boolean deleteRight) {
        this.deleteRight = deleteRight;
    }

    /**
     * Setter for the group's id. It must not be null or empty.
     *
     * @param groupId
     *            the group's id
     */
    public void setGroupId(final String groupId) {
        this.groupId = groupId;
    }

    /**
     * Setter for the read right.
     *
     * @param readRight
     *            true if the group members should have read right and false if
     *            not
     */
    public void setReadRight(final boolean readRight) {
        this.readRight = readRight;
    }

    /**
     * Setter for the update right.
     *
     * @param updateRight
     *            true if the group members should have update right and false
     *            if not
     */
    public void setUpdateRight(final boolean updateRight) {
        this.updateRight = updateRight;
    }

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // abstract methods
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // override methods
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    /*
     * This method is not needed in the OpenAPE-Server. public boolean
     * equals(Object otherObject) { boolean result = true; if (otherObject ==
     * null || otherObject instanceof GroupAccessRight == false) { result =
     * false; } else { GroupAccessRight otherGroupAccessRight =
     * (GroupAccessRight) otherObject; if (this.groupId !=
     * otherGroupAccessRight.getGroupId()) { result = false; } if
     * (this.resourceId.equals(otherGroupAccessRight.getResourceId()) == false)
     * { result = false; } if (this.readRight !=
     * otherGroupAccessRight.hasReadRight()) { result = false; } if
     * (this.updateRight != otherGroupAccessRight.hasUpdateRight()) { result =
     * false; } if (this.deleteRight != otherGroupAccessRight.hasDeleteRight())
     * { result = false; } if (this.changeRightsRight !=
     * otherGroupAccessRight.hasChangeRightsRight()) { result = false; } }
     * return result; }
     */

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // public methods
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // protected methods
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // private methods
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************
    // inner classes
    // *********************************************************************************************************************************************
    // *********************************************************************************************************************************************

}
