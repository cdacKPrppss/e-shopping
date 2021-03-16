import React from 'react';
import { Typography, Button, Card, CardActions, CardContent, CardMedia } from '@material-ui/core';

import useStyles from './styles';


const CartItem = ({ item }) => {
    const classes = useStyles();

    return (
        <Card>
            <CardMedia image={item.url} alt={item.name} className={classes.media} />
            <CardContent className={classes.cardContent}>
                 <Typography variant="h4">{item.name}</Typography>
                <Typography variant="h5">{item.price}</Typography>
            </CardContent>
            
        </Card>
    )
}

export default CartItem
