import axios from 'axios';
import QS from 'qs'
let baseUrl = 'http://localhost:8080'
// let baseUrl = 'api'

export function get(url, params) {
  return new Promise((resolve, reject) => {
    axios.get(baseUrl + url, {
      params: params
    }).then(res => {
      resolve(res.data);
    }).catch(err => {
      reject(err.data)
    })
  });
}

export function post(url, params) {
  return new Promise((resolve, reject) => {
    axios.post(baseUrl + url, params)
      .then(res => {
        resolve(res.data);
      })
      .catch(err => {
        reject(err.data)
      })
  });
}

export default {
  get: get,
  post: post,
  url: baseUrl
}