import { defineStore } from 'pinia';

export const PageParamsStore = defineStore('pageParams', {
  state: () => ({
    key: ''
  }),
  actions: {
    setKey(key) {
      this.key = key;
    }
  }
});