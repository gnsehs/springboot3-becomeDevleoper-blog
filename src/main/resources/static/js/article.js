// 삭제 기능
const deleteButton = document.getElementById('delete-btn'); // html에서 id를 delete-btn으로 설정한 엘리멘트를 찾는다.

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, { // 클릭 이벤트가 발생하면 fetch 이벤트를 통해 delete요청을 보낸다.
            method: 'DELETE'
        })
            .then(() => { // fetch가 잘 발생하면 연이어 발생
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });
}

