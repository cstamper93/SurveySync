<template>
  <div>
    <nav>
      <ul>
        <li><img class="logo" alt="Vue logo" src="../src/assets/survey-sync.png"></li>
        <li>User Profile</li>
        <li><router-link to="/new-prospect">+New</router-link></li>
        <li><router-link to="/">Prospects</router-link></li>
        <li><router-link to="/clients">Clients</router-link></li>
        <li>Active Jobs</li>
        <li>Declined/Archived</li>
      </ul>
    </nav>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

nav {
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: blue;
}

.logo {
  width: 75%;
  height: auto;
  margin-bottom: 50px;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 20%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
  text-align: center;
}

li {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}
</style>
