import axios from "axios";

export const http = axios.create({
  // DEV
  // baseURL: "http://localhost:8080/",
  // HEROKU
  baseURL: "http://livresbs.herokuapp.com",
});
