import http from "./http-common";

const create = data => {
    return http.post("/users", data);
};
  
const get = () => {
    return http.get("/users");
};

export default {
    create,
    get
}