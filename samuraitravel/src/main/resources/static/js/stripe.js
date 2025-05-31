const stripe = Stripe('pk_test_51RDKi702VmKedohTv1jfL5zMxMUWCtzPRZendYsHMzrSLwWktL9e6xhqg49UhtQFyxb5OvApQD0pRayl01f3Y25k00mXIhrL0N');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
 stripe.redirectToCheckout({
   sessionId: sessionId
 })
});