import React, { useState, useEffect } from 'react';
import { CssBaseline, Paper, Stepper, Step, StepLabel, Typography, CircularProgress, Divider, Button } from '@material-ui/core';
import { Link } from 'react-router-dom';

import useStyles from './styles';
import AddressForm from '../AddressForm';
import PaymentForm from '../PaymentForm';

const steps = ['Shipping address', 'Payment details'];

const Checkout = ({ caart }) => {
  const [activeStep, setActiveStep] = useState(0);
  const [checkoutToken, setCheckoutToken] = useState(null);
  const [shippingData, setShippingData] = useState({});
    const classes = useStyles();
    

  
  const nextStep = () => setActiveStep((prevActiveStep) => prevActiveStep + 1);
  const backStep = () => setActiveStep((prevActiveStep) => prevActiveStep-1);

  const next = (data) => {
    setShippingData(data);
    nextStep();
  }
  
    const Confirmation = () => (
      <>
        <div>
          <Typography variant="h5">Thank you for your purchase firstname  lastname!</Typography>
          <Divider className={classes.divider} />
          <Typography variant="subtitle2">Order ref: 3453335</Typography>
          <Typography variant="h5">Modifications required: 
            <br /> 1. login(Auth) // optional
            <br /> 2. orderid/token generation
            <br /> 3. transfer shipping data and order data to server side
            
            <br /> 4. tables for login, (shipping data and order data) related to orderid
            <br /> 6. use post method in axios
            <br /> 7. use context for passing props
            <br /> 8. payment transaction remove stripekey

          </Typography>
          
        </div>
        <br />
        <Button component={Link} variant="outlined" type="button" to="/"  >Continue Shopping</Button>
      </>
    );
  
  
    const Form = () => activeStep === 0
      ? <AddressForm  next={next} />
      : <PaymentForm shippingData={shippingData} caart={caart}
          backStep={backStep} nextStep={nextStep}  />
    
  
  
    return (
        <>
      <CssBaseline />
      <div className={classes.toolbar} />
      <main className={classes.layout}>
        <Paper className={classes.paper}>
          <Typography variant="h4" align="center">Checkout</Typography>
          <Stepper activeStep={activeStep} className={classes.stepper}>
            {steps.map((step) => (
              <Step key={step}>
                <StepLabel>{step}</StepLabel>
              </Step>
            ))}
            </Stepper>
            {activeStep === steps.length ? <Confirmation /> : caart && <Form />}
        </Paper>
      </main>
    </>
    )
}

export default Checkout;
