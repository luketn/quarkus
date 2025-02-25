package io.quarkus.it.spring.data.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phone_call")
public class PhoneCall extends AbstractPhoneEntity<PhoneCallId> {

    private int duration;

    private CallAgent callAgent;

    PhoneCall() { // only for hibernate
        super(null);
    }

    public PhoneCall(PhoneCallId id) {
        super(id);
    }

    public int getDuration() {
        return duration;
    }

    public CallAgent getCallAgent() {
        return callAgent;
    }

    @Embeddable
    public static class CallAgent {
        @Column(name = "agent_first_name")
        private String firstName;
        @Column(name = "agent_last_name")
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
