/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.newsradar.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUXIAOFENG
 */
@Entity
@Table(name = "news_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsItem.findAll", query = "SELECT n FROM NewsItem n"),
    @NamedQuery(name = "NewsItem.findById", query = "SELECT n FROM NewsItem n WHERE n.id = :id"),
    @NamedQuery(name = "NewsItem.findByVersion", query = "SELECT n FROM NewsItem n WHERE n.version = :version"),
    @NamedQuery(name = "NewsItem.findByIndustry", query = "SELECT n FROM NewsItem n WHERE n.industry = :industry"),
    @NamedQuery(name = "NewsItem.findByCategory", query = "SELECT n FROM NewsItem n WHERE n.category = :category")})
public class NewsItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "version")
    private Integer version;
    @Size(max = 255)
    @Column(name = "industry")
    private String industry;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @JoinColumn(name = "news_raw_item_id", referencedColumnName = "id")
    @ManyToOne
    private NewsRawItem newsRawItemId;

    public NewsItem() {
    }

    public NewsItem(Long id) {
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public NewsRawItem getNewsRawItemId() {
        return newsRawItemId;
    }

    public void setNewsRawItemId(NewsRawItem newsRawItemId) {
        this.newsRawItemId = newsRawItemId;
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
        if (!(object instanceof NewsItem)) {
            return false;
        }
        NewsItem other = (NewsItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.newsradar.entity.NewsItem[ id=" + id + " ]";
    }
    
}
