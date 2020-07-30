import request from "./config";
import { API_PATH } from "./path";

export const resGenGetTable = () => request(API_PATH + "gen/genTable", null, "GET");
export const resGenGetTableColumn = data => request(API_PATH + "gen/genTableColumn", data, "GET");
export const resGenGenTemplate = data => request(API_PATH + "gen/genTemplate", data, "GET");

/**
 * 项目管理
 */
export const resApiProjectsQueryPage = data => request(API_PATH + "projects/queryPage", data, "POST");
export const resApiProjectsQueryAll = data => request(API_PATH + "projects/queryAll", data, "GET");
export const resApiProjectsQueryOne = data => request(API_PATH + "projects/queryOne", data, "GET");
export const resApiProjectsSave = data => request(API_PATH + "projects/save", data, "POST");
export const resApiProjectsUpdate = data => request(API_PATH + "projects/update", data, "PUT");
export const resApiProjectsDelete = data => request(API_PATH + "projects/delete", data, "DELETE");


/**
 * 数据库管理
 */
export const resApiDatabaseQueryPage = data => request(API_PATH + "database/queryPage", data, "POST");
export const resApiDatabaseQueryAll = data => request(API_PATH + "database/queryAll", data, "GET");
export const resApiDatabaseQueryOne = data => request(API_PATH + "database/queryOne", data, "GET");
export const resApiDatabaseSave = data => request(API_PATH + "database/save", data, "POST");
export const resApiDatabaseUpdate = data => request(API_PATH + "database/update", data, "PUT");
export const resApiDatabaseDelete = data => request(API_PATH + "database/delete", data, "DELETE");
export const resgetUpdateDataTable = data => request(API_PATH + "database/getUpdateDataTable", data, "GET");


/**
 * 表字段
 */
export const resApiColumnQueryPage = data => request(API_PATH + "column/queryPage", data, "POST");
export const resApiColumnQueryAll = data => request(API_PATH + "column/queryAll", data, "GET");
export const resApiColumnQueryOne = data => request(API_PATH + "column/queryOne", data, "GET");
export const resApiColumnSave = data => request(API_PATH + "column/save", data, "POST");
export const resApiColumnUpdate = data => request(API_PATH + "column/update", data, "PUT");
export const resApiColumnDelete = data => request(API_PATH + "column/delete", data, "DELETE");