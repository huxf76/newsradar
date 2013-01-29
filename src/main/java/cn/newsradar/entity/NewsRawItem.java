/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.newsradar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUXIAOFENG
 */
@Entity
@Table(name = "news_raw_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsRawItem.findAll", query = "SELECT n FROM NewsRawItem n"),
    @NamedQuery(name = "NewsRawItem.findById", query = "SELECT n FROM NewsRawItem n WHERE n.id = :id"),
    @NamedQuery(name = "NewsRawItem.findByVersion", query = "SELECT n FROM NewsRawItem n WHERE n.version = :version"),
    @NamedQuery(name = "NewsRawItem.findByCreated", query = "SELECT n FROM NewsRawItem n WHERE n.created = :created"),
    @NamedQuery(name = "NewsRawItem.findByRawId", query = "SELECT n FROM NewsRawItem n WHERE n.rawId = :rawId")})
public class NewsRawItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "version")
    private Integer version;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "raw_id")
    private String rawId;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @OneToMany(mappedBy = "newsRawItemId")
    private List<NewsItem> newsItemList;

    public NewsRawItem() {
    }

    public NewsRawItem(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getRawId() {
        return rawId;
    }

    public void setRawId(String rawId) {
        this.rawId = rawId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlTransient
    public List<NewsItem> getNewsItemList() {
        return newsItemList;
    }

    public void setNewsItemList(List<NewsItem> newsItemList) {
        this.newsItemList = newsItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsRawItem)) {
            return false;
        }
        NewsRawItem other = (NewsRawItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.newsradar.entity.NewsRawItem[ id=" + id + " ]";
    }
    
}
