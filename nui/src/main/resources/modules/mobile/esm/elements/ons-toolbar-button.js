import _Object$getPrototypeOf from 'babel-runtime/core-js/object/get-prototype-of';
import _classCallCheck from 'babel-runtime/helpers/classCallCheck';
import _createClass from 'babel-runtime/helpers/createClass';
import _possibleConstructorReturn from 'babel-runtime/helpers/possibleConstructorReturn';
import _inherits from 'babel-runtime/helpers/inherits';
import onsElements from '../ons/elements';
import BaseButtonElement from './base/base-button';
/*
Copyright 2013-2015 ASIAL CORPORATION

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/

/**
 * @element ons-toolbar-button
 * @category page
 * @modifier material
 *   [en]Material Design toolbar button.[/en]
 *   [ja][/ja]
 * @modifier outline
 *   [en]A button with an outline.[/en]
 *   [ja]アウトラインをもったボタンを表示します。[/ja]
 * @description
 *   [en]Button component for ons-toolbar and ons-bottom-toolbar.[/en]
 *   [ja]ons-toolbarあるいはons-bottom-toolbarに設置できるボタン用コンポーネントです。[/ja]
 * @codepen aHmGL
 * @tutorial vanilla/Reference/page
 * @guide compilation.html#toolbar-compilation
 *   [en]Adding a toolbar[/en]
 *   [ja]ツールバーの追加[/ja]
 * @seealso ons-toolbar
 *   [en]The `<ons-toolbar>` component displays a navigation bar at the top of a page.[/en]
 *   [ja]ons-toolbarコンポーネント[/ja]
 * @seealso ons-back-button
 *   [en]The `<ons-back-button>` displays a back button in the navigation bar.[/en]
 *   [ja]ons-back-buttonコンポーネント[/ja]
 * @example
 * <ons-toolbar>
 *   <div class="left">
 *     <ons-toolbar-button>
 *       Button
 *     </ons-toolbar-button>
 *   </div>
 *   <div class="center">
 *     Title
 *   </div>
 *   <div class="right">
 *     <ons-toolbar-button>
 *       <ons-icon icon="ion-navicon" size="28px"></ons-icon>
 *     </ons-toolbar-button>
 *   </div>
 * </ons-toolbar>
 */

var ToolbarButtonElement = function (_BaseButtonElement) {
	_inherits(ToolbarButtonElement, _BaseButtonElement);

	function ToolbarButtonElement() {
		_classCallCheck(this, ToolbarButtonElement);

		return _possibleConstructorReturn(this, (ToolbarButtonElement.__proto__ || _Object$getPrototypeOf(ToolbarButtonElement)).apply(this, arguments));
	}

	_createClass(ToolbarButtonElement, [{
		key: '_scheme',


		/**
		 * @attribute modifier
		 * @type {String}
		 * @description
		 *   [en]The appearance of the button.[/en]
		 *   [ja]ボタンの表現を指定します。[/ja]
		 */

		/**
		 * @attribute icon
		 * @type {String}
		 * @description
		 *  [en]Creates an `ons-icon` component with this string.[/en]
		 *  [ja]`ons-icon`コンポーネントを悪性します。[/ja]
		 */

		/**
		 * @attribute disabled
		 * @description
		 *   [en]Specify if button should be disabled.[/en]
		 *   [ja]ボタンを無効化する場合は指定してください。[/ja]
		 */

		/**
		 * @property disabled
		 * @type {Boolean}
		 * @description
		 *   [en]Whether the element is disabled or not.[/en]
		 *   [ja]無効化されている場合に`true`。[/ja]
		 */

		get: function get() {
			return {'': 'toolbar-button--*'};
		}
	}, {
		key: '_defaultClassName',
		get: function get() {
			return 'toolbar-button';
		}
	}, {
		key: '_rippleOpt',
		get: function get() {
			return [this, undefined, {center: '', 'size': 'contain', 'background': 'transparent'}];
		}
	}]);

	return ToolbarButtonElement;
}(BaseButtonElement);

export default ToolbarButtonElement;


onsElements.ToolbarButton = ToolbarButtonElement;
customElements.define('ons-toolbar-button', ToolbarButtonElement);