import { registerPlugin } from '@capacitor/core';

import type { veerPlugin } from './definitions';

const veer = registerPlugin<veerPlugin>('veer', {
  web: () => import('./web').then(m => new m.veerWeb()),
});

export * from './definitions';
export { veer };
