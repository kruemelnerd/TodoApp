/* eslint-disable */
import axios from 'axios'

const API_URL = '/api/auth/'

class AuthService {
    login(user) {
      return axios
        .post(API_URL + 'signin', {
          username: user.username,
          password: user.password
        })
        .then(this.handleResponse)
        .then(response => {
          if(response.data.accessToken){
            localStorage.setItem('user', JSON.stringify(response.data))
          }
          return response.data;
        })
    }

    logout(){
      localStorage.removeItem('user');
    }
    register(user) {
      return axios.post(API_URL + 'signup',{
        username: user.username,
        password: user.password
      })
    }

  handleResponse(response) {
    if (response.status === 401) {
      this.logout();
      location.reload();

      const error = response.data && response.data.message;
      return Promise.reject(error);
    }

    return Promise.resolve(response);
  }
}
export default new AuthService()
