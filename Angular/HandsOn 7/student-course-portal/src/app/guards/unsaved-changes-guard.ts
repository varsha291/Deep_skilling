import { CanDeactivateFn } from '@angular/router';

export const unsavedChangesGuard: CanDeactivateFn<any> = () => {
  return confirm('Discard unsaved changes?');
};