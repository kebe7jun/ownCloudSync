package com.kebe7jun.data.object;

/**
 * Created by KEBE on 1/3/2016.
 */
public class OWFile {

    /**
     * The follow vars are decode from
     * {"data":{"directory":"\/","files":[{"id":"171","parentId":"2","date":"2015\u5e7412\u670813\u65e5 GMT+8\u4e0b\u53489:17:24","mtime":1450012644000,"icon":"\/core\/img\/filetypes\/folder.svg","name":"code","permissions":31,"mimetype":"httpd\/unix-directory","size":3973,"type":"dir","etag":"566d6fe4d1d43"},{"id":"7","parentId":"2","date":"2015\u5e7412\u670810\u65e5 GMT+8\u4e0b\u53489:39:34","mtime":1449754774000,"icon":"\/core\/img\/filetypes\/folder.svg","name":"Documents","permissions":31,"mimetype":"httpd\/unix-directory","size":2820867,"type":"dir","etag":"56698096d144c"},{"id":"3","parentId":"2","date":"2016\u5e741\u67083\u65e5 GMT+8\u4e0b\u53485:21:23","mtime":1451812883000,"icon":"\/core\/img\/filetypes\/folder.svg","name":"Photos","permissions":31,"mimetype":"httpd\/unix-directory","size":4740180893,"type":"dir","etag":"5688e813df7ca"},{"id":"139","parentId":"2","date":"2015\u5e7412\u670826\u65e5 GMT+8\u4e0a\u534812:13:05","mtime":1451059985000,"icon":"\/core\/img\/filetypes\/folder.svg","name":"Projects","permissions":31,"mimetype":"httpd\/unix-directory","size":147338567,"type":"dir","etag":"567d6b110e318"},{"id":"29000","parentId":"2","date":"2015\u5e7412\u670831\u65e5 GMT+8\u4e0b\u53482:38:20","mtime":1451543900000,"icon":"\/core\/img\/filetypes\/folder.svg","name":"SelfData","permissions":31,"mimetype":"httpd\/unix-directory","size":6267,"type":"dir","etag":"5684cd5c81779"},{"id":"52","parentId":"2","date":"2015\u5e7412\u670831\u65e5 GMT+8\u4e0b\u534810:30:23","mtime":1451572223000,"icon":"\/core\/img\/filetypes\/folder.svg","name":"Tools","permissions":31,"mimetype":"httpd\/unix-directory","size":120929201,"type":"dir","etag":"56853bffee319"},{"id":"147","parentId":"2","date":"2015\u5e7412\u670810\u65e5 GMT+8\u4e0b\u53489:34:47","mtime":1449754487000,"icon":"\/core\/img\/filetypes\/folder.svg","name":"Videos","permissions":31,"mimetype":"httpd\/unix-directory","size":827518923,"type":"dir","etag":"56697f77b9c17"}],"permissions":31},"status":"success"}
     */
    private int id;
    private int parentId;
    private String date;
    private long mtime;
    private String icon;
    private String name;
    private int permission;
    private String mimetype;
    private int size;
    private String type;
    private String etag;

    /**
     * @param id
     * @param parentId
     * @param date
     * @param mtime
     * @param icon
     * @param name
     * @param permission
     * @param mimetype
     * @param size
     * @param type
     * @param etag
     */
    public OWFile(int id, int parentId, String date, long mtime, String icon, String name, int permission, String mimetype, int size, String type, String etag) {
        this.id = id;
        this.parentId = parentId;
        this.date = date;
        this.mtime = mtime;
        this.icon = icon;
        this.name = name;
        this.permission = permission;
        this.mimetype = mimetype;
        this.size = size;
        this.type = type;
        this.etag = etag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getMtime() {
        return mtime;
    }

    public void setMtime(long mtime) {
        this.mtime = mtime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
