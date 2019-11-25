/* eslint-disable */
export default function authHeader() {
  let user = JSON.parse(localStorage.getItem('user'))

  if(user && user.accessToken){
    return { Authorization: 'Bearer ' + user.accessToken, 'Content-Type': 'application/json;charset=UTF-8'}
  }else{
    return {}
  }
}
