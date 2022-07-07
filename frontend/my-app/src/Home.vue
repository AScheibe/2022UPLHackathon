<template>
  <div>
    <h1>{{ title }}</h1>
  </div>
</template>



<script>
export default {
  name: "home",
  data() {
    return {
      title: " ",
    };
  },

  mounted() {
    fetch("http://10.140.186.79:8080")
      .then((response) => {
        return response.text();
      })
      .then((data) => {
        this.title = data;
      });
  },
};
</script>
