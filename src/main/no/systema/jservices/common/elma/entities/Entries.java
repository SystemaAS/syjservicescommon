package no.systema.jservices.common.elma.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "entries", "page", "pages", "posts" })
public class Entries {

	@JsonProperty("entries")
	private List<Entry> entries = null;
	@JsonProperty("page")
	private Integer page;
	@JsonProperty("pages")
	private Integer pages;
	@JsonProperty("posts")
	private Integer posts;

	@JsonProperty("entries")
	public List<Entry> getEntries() {
		return entries;
	}

	@JsonProperty("entries")
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@JsonProperty("page")
	public Integer getPage() {
		return page;
	}

	@JsonProperty("page")
	public void setPage(Integer page) {
		this.page = page;
	}

	@JsonProperty("pages")
	public Integer getPages() {
		return pages;
	}

	@JsonProperty("pages")
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@JsonProperty("posts")
	public Integer getPosts() {
		return posts;
	}

	@JsonProperty("posts")
	public void setPosts(Integer posts) {
		this.posts = posts;
	}

}
