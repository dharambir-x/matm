import { registerPlugin } from '@capacitor/core';
const veer = registerPlugin('veer', {
    web: () => import('./web').then(m => new m.veerWeb()),
});
export * from './definitions';
export { veer };
//# sourceMappingURL=index.js.map