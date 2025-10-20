ALTER TABLE raffle_model
ADD COLUMN winner_ticket_id BIGINT;

ALTER TABLE raffle_model
ADD CONSTRAINT fk_ticket_winner
FOREIGN KEY (winner_ticket_id) REFERENCES raffle_ticket_model(id);