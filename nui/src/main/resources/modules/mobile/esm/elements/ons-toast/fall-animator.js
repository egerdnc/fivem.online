import _Object$getPrototypeOf from 'babel-runtime/core-js/object/get-prototype-of';
import _classCallCheck from 'babel-runtime/helpers/classCallCheck';
import _createClass from 'babel-runtime/helpers/createClass';
import _possibleConstructorReturn from 'babel-runtime/helpers/possibleConstructorReturn';
import _inherits from 'babel-runtime/helpers/inherits';
import animit from '../../ons/animit';
import iPhoneXPatch from '../../ons/iphonex-patch';
import ToastAnimator from './animator';

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
 * Fall-fade Toast Animator
 */

var FallToastAnimator = function (_ToastAnimator) {
	_inherits(FallToastAnimator, _ToastAnimator);

	function FallToastAnimator() {
		var _ref = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {},
			_ref$timing = _ref.timing,
			timing = _ref$timing === undefined ? 'ease' : _ref$timing,
			_ref$delay = _ref.delay,
			delay = _ref$delay === undefined ? 0 : _ref$delay,
			_ref$duration = _ref.duration,
			duration = _ref$duration === undefined ? 0.35 : _ref$duration;

		_classCallCheck(this, FallToastAnimator);

		var _this = _possibleConstructorReturn(this, (FallToastAnimator.__proto__ || _Object$getPrototypeOf(FallToastAnimator)).call(this, {
			timing: timing,
			delay: delay,
			duration: duration
		}));

		if (iPhoneXPatch.isIPhoneXPortraitPatchActive()) {
			_this.fallAmount = 'calc(-100% - 44px)';
		} else {
			_this.fallAmount = '-100%';
		}
		return _this;
	}

	/**
	 * @param {HTMLElement} toast
	 * @param {Function} callback
	 */


	_createClass(FallToastAnimator, [{
		key: 'show',
		value: function show(toast, callback) {
			toast = toast._toast;
			this._updatePosition(toast);

			animit.runAll(animit(toast, this.def).default({
				transform: 'translate3d(0, ' + this.fallAmount + ', 0)',
				opacity: 0
			}, {transform: 'translate3d(0, 0, 0)', opacity: 1}).queue(function (done) {
				callback && callback();
				done();
			}));
		}

		/**
		 * @param {HTMLElement} toast
		 * @param {Function} callback
		 */

	}, {
		key: 'hide',
		value: function hide(toast, callback) {
			var _this2 = this;

			toast = toast._toast;
			this._updatePosition(toast);

			animit.runAll(animit(toast, this.def).default({
				transform: 'translate3d(0, 0, 0)',
				opacity: 1
			}, {transform: 'translate3d(0, ' + this.fallAmount + ', 0)', opacity: 0}).queue(function (done) {
				_this2._updatePosition(toast, true);
				callback && callback();
				done();
			}));
		}
	}, {
		key: '_updatePosition',
		value: function _updatePosition(toast, cleanUp) {
			var correctTop = void 0;
			if (iPhoneXPatch.isIPhoneXPortraitPatchActive()) {
				correctTop = '44px';
			} else {
				correctTop = '0';
			}

			if (toast.style.top !== correctTop) {
				toast.style.top = correctTop;
				toast.style.bottom = 'initial';
			}
		}
	}]);

	return FallToastAnimator;
}(ToastAnimator);

export default FallToastAnimator;