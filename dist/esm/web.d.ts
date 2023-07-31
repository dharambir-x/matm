import { WebPlugin } from '@capacitor/core';
import type { veerPlugin } from './definitions';
export declare class veerWeb extends WebPlugin implements veerPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
