<template>
   <div>
  <router-view />
  </div>
</template>

<script>


export default {
  data() {
    return {
      message: '',
      messages: [],
      socket: null
    };
  },


};
</script>