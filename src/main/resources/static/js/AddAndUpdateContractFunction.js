/**
 * 作成者：顔
 * 作成日：2024/09/26
 * sessionStorageに関するsetterとgetterの定義
 */
function setSession(key, value) {
    sessionStorage.setItem(key, value);
}

function getSession(key) {
    return sessionStorage.getItem(key);
}

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * ページが読み込まれた際に初期化処理を実行
 */
window.onload = function() {
    handlePageChange(1, true); // ページが初期化時に必須フィールドのチェックをスキップ
}

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 現在のページが指定されたページと一致しているかどうかを確認する関数
 */
function isPageActive(thePage) {
    const currentPage = getSession('page');
    return parseInt(currentPage) === thePage;
}

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * ページの切り替えと、必須フィールドのバリデーションを行う関数
 * 第二引数 skipValidation は初期化時にバリデーションをスキップするためのフラグ
 */
function handlePageChange(thePage, skipValidation = false) {
    // 初期化時以外のときは必須フィールドをチェック
    if (!skipValidation) {
        // プレースホルダーに「必須フィールド」が指定されたinput要素をすべて取得
		const currentStep = document.getElementById(`step${getSession('page')}`);
        const inputs = currentStep.querySelectorAll('input[placeholder="必須フィールド"]');
		console.log(inputs);
        let allValid = true; // すべての必須フィールドが入力されているかを示すフラグ

        // すべてのinput要素をループして入力内容をチェック
        inputs.forEach(input => {
            // 空のフィールドがあればallValidをfalseに設定
            if (!input.value.trim()) {
                allValid = false;
            }
        });

        // 必須フィールドが入力されていない場合は警告を表示し、処理を中断
        if (!allValid) {
            alert('すべての必須フィールドに入力してください');
            return;
        }
    }

    // 現在のページ番号をsessionStorageに保存
    setSession('page', thePage);

    // ページ選択用のp要素をすべて取得し、クラスを更新
    const pages = document.querySelectorAll('.set p');
    pages.forEach(page => {
        // すべてのページ選択用p要素から"check"クラスを削除
        page.classList.remove('check');
    });

    // 現在のページに該当するp要素に"check"クラスを追加
    document.getElementById(`page${thePage}`).classList.add('check');

    // ページタイトルを更新
    let title = '';
    switch (thePage) {
        case 1: title = '建物情報を確認'; break;
        case 2: title = '契約内容を登録'; break;
        case 3: title = '契約情報を確認'; break;
    }

    document.getElementById('pageTitle').innerText = title;

    // すべてのページコンテンツを非表示にする
    const pageContents = document.querySelectorAll('[id^="step"]');
    pageContents.forEach(content => {
        content.style.display = 'none';
    });

    // 現在のページに対応するコンテンツを表示
    document.getElementById(`step${thePage}`).style.display = 'block';
}

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 契約期間を計算する関数
 */
function calculatePeriod() {
    // 開始日（startDate）と終了日（endDate）を取得
    const startDate = new Date(document.getElementById('startDate').value);
    const endDate = new Date(document.getElementById('endDate').value);

    // 日付のフォーマットが不正な場合、契約期間をクリアして処理を終了
    if (isNaN(startDate) || isNaN(endDate)) {
        document.getElementById('contractPeriod').innerText = '';
        return;
    }

    // 年・月・日の差を計算
    let years = endDate.getFullYear() - startDate.getFullYear();
    let months = endDate.getMonth() - startDate.getMonth();
    let days = endDate.getDate() - startDate.getDate();

    // 日が負の値になる場合、前月に戻して日数を再計算
    if (days < 0) {
        months--;
        // 開始日が属する月の日数を追加して調整
        days += new Date(startDate.getFullYear(), startDate.getMonth() + 1, 0).getDate();
    }

    // 月が負の値になる場合、前年に戻して月数を再計算
    if (months < 0) {
        years--;
        months += 12;
    }

    // 計算結果を契約期間（contractPeriod）に表示
    document.getElementById('contractPeriod').innerText = `${years}年${months}月${days}日`;
}

// 開始日または終了日が変更された際に期間を再計算
document.getElementById('startDate').addEventListener('change', calculatePeriod);
document.getElementById('endDate').addEventListener('change', calculatePeriod);

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 管理費支払額と支払日を同期する関数
 */
function syncPayments() {
    // 家賃支払額（rentPay）と家賃支払日（rentPayDay）を取得
    const rentPay = document.getElementById('rentPay').value;
    const rentPayDay = document.getElementById('rentPayDay').value;

    // 管理費支払額（managementFeePay）と管理費支払日（managementFeePayDay）に家賃の値を同期
    document.getElementById('managementFeePay').value = rentPay;
    document.getElementById('managementFeePayDay').value = rentPayDay;
}

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 管理費支払額と支払日をクリアする関数
 */
function clearManagementFeeFields() {
    // 管理費支払額と支払日をクリア
    document.getElementById('managementFeePay').value = '';
    document.getElementById('managementFeePayDay').value = '';
}

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 家賃支払額が変更された時に、同時支払が選択されている場合は管理費の値を同期
 */
document.getElementById('rentPay').addEventListener('change', () => {
    if (document.getElementById('sameTimePayment').checked) {
        syncPayments();
    }
});

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 家賃支払日が変更された時に、同時支払が選択されている場合は管理費の値を同期
 */
document.getElementById('rentPayDay').addEventListener('change', () => {
    if (document.getElementById('sameTimePayment').checked) {
        syncPayments();
    }
});

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 同時支払（sameTimePayment）が選択または解除された時の処理
 */
document.getElementById('sameTimePayment').addEventListener('change', function() {
    if (this.checked) {
        // 同時支払が選択された場合、家賃の値を管理費に同期
        syncPayments();
    } else {
        // 同時支払が解除された場合、管理費のフィールドをクリア
        clearManagementFeeFields();
    }
});

/**
 * 作成者：顔
 * 作成日：2024/09/26
 * 支払方法の選択によって表示内容を切り替える関数
 */
function togglePaymentDetails() {
    const paymentMethod = document.getElementById('paymentMethod').value;
    const paymentDetails = document.getElementById('paymentDetails');
    const transferFeePayer = document.getElementById('transferFeePayer');
    const handingFeeDetails = document.getElementById('handingFeeDetails');
    const payment = document.getElementById('payment');
    const handing = document.getElementById('handing');

    // 支払方法に応じて表示を切り替える
    if (paymentMethod === '振り込み') {
        paymentDetails.style.display = 'flex';
        transferFeePayer.style.display = 'flex';
        handingFeeDetails.style.display = 'none';
        payment.style.display = 'flex';
        handing.style.display = 'none';
    } else if (paymentMethod === '持参') {
        paymentDetails.style.display = 'none';
		transferFeePayer.style.display = 'none';
        handingFeeDetails.style.display = 'flex';
		payment.style.display = 'none';
		handing.style.display = 'flex';
    } else {
        paymentDetails.style.display = 'none';
		transferFeePayer.style.display = 'none';
        handingFeeDetails.style.display = 'none';
		payment.style.display = 'none';
		handing.style.display = 'none';
    }
}
