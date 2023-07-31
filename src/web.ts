import { WebPlugin } from '@capacitor/core';

import type { veerPlugin } from './definitions';

export class veerWeb extends WebPlugin implements veerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
