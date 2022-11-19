package io.ukoko.bhwms.entity;


import java.util.Date;
/**
 * 映射数据库user_repository(用户仓库关联表)表
 */
public class UserRepository {

    /*
      仓库ID
     */
    private Integer repoId;
    /*
      仓库(多对多)
     */
    private Repository repository;
    /*
      用户ID
     */
    private Integer userId;
    /*
      用户(多对多)
     */
    private User user;
    /*
      创建时间
     */
    private Date createTime;
    /*
      更新时间
     */
    private Date updateTime;
    /*
      是否删除 0:删除 1:未删除
     */
    private int isDelete=1;

    public UserRepository() {
    }

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "repoId=" + repoId +
                ", repository=" + repository +
                ", userId=" + userId +
                ", user=" + user +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
