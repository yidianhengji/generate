import request from "./config";
import { API_PATH } from "./path";

export const resGenGetTable = () =>
  request(API_PATH + "gen/genTable", null, "GET");

export const resGenGetTableColumn = data =>
  request(API_PATH + "gen/genTableColumn", data, "GET");
