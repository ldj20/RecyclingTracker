import { http, httpA } from "./http-common";

const create = data => {
    return http.post("/users", data);
};
  
const get = () => {
    return http.get("/users");
};

const getById = (id, token) => {
    const authHTTP = httpA(token);
    return authHTTP.get(`/users/${id}`)
}

const getDisplay = (id, token) => {
    const authHTTP = httpA(token);
    return authHTTP.get(`/users/display/${id}`)
}

const getLabels = img => {
    return http.post("/services/getLabelDetection", img);
}

export default {
    create,
    get,
    getById,
    getDisplay,
    getLabels,
}