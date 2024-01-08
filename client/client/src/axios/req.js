import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:7001/' ,// 设置基本的 URL
  headers: {
    'Content-Type': 'application/json', // 设置请求头的 Content-Type 字段为 application/json
  }
});

export default axiosInstance;