package cn.yyy.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProblemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProblemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProblemidIsNull() {
            addCriterion("problemid is null");
            return (Criteria) this;
        }

        public Criteria andProblemidIsNotNull() {
            addCriterion("problemid is not null");
            return (Criteria) this;
        }

        public Criteria andProblemidEqualTo(Integer value) {
            addCriterion("problemid =", value, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidNotEqualTo(Integer value) {
            addCriterion("problemid <>", value, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidGreaterThan(Integer value) {
            addCriterion("problemid >", value, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("problemid >=", value, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidLessThan(Integer value) {
            addCriterion("problemid <", value, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidLessThanOrEqualTo(Integer value) {
            addCriterion("problemid <=", value, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidIn(List<Integer> values) {
            addCriterion("problemid in", values, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidNotIn(List<Integer> values) {
            addCriterion("problemid not in", values, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidBetween(Integer value1, Integer value2) {
            addCriterion("problemid between", value1, value2, "problemid");
            return (Criteria) this;
        }

        public Criteria andProblemidNotBetween(Integer value1, Integer value2) {
            addCriterion("problemid not between", value1, value2, "problemid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidIsNull() {
            addCriterion("releasestudentid is null");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidIsNotNull() {
            addCriterion("releasestudentid is not null");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidEqualTo(Integer value) {
            addCriterion("releasestudentid =", value, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidNotEqualTo(Integer value) {
            addCriterion("releasestudentid <>", value, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidGreaterThan(Integer value) {
            addCriterion("releasestudentid >", value, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("releasestudentid >=", value, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidLessThan(Integer value) {
            addCriterion("releasestudentid <", value, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidLessThanOrEqualTo(Integer value) {
            addCriterion("releasestudentid <=", value, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidIn(List<Integer> values) {
            addCriterion("releasestudentid in", values, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidNotIn(List<Integer> values) {
            addCriterion("releasestudentid not in", values, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidBetween(Integer value1, Integer value2) {
            addCriterion("releasestudentid between", value1, value2, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andReleasestudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("releasestudentid not between", value1, value2, "releasestudentid");
            return (Criteria) this;
        }

        public Criteria andProblemnameIsNull() {
            addCriterion("problemname is null");
            return (Criteria) this;
        }

        public Criteria andProblemnameIsNotNull() {
            addCriterion("problemname is not null");
            return (Criteria) this;
        }

        public Criteria andProblemnameEqualTo(String value) {
            addCriterion("problemname =", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameNotEqualTo(String value) {
            addCriterion("problemname <>", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameGreaterThan(String value) {
            addCriterion("problemname >", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameGreaterThanOrEqualTo(String value) {
            addCriterion("problemname >=", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameLessThan(String value) {
            addCriterion("problemname <", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameLessThanOrEqualTo(String value) {
            addCriterion("problemname <=", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameLike(String value) {
            addCriterion("problemname like", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameNotLike(String value) {
            addCriterion("problemname not like", value, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameIn(List<String> values) {
            addCriterion("problemname in", values, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameNotIn(List<String> values) {
            addCriterion("problemname not in", values, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameBetween(String value1, String value2) {
            addCriterion("problemname between", value1, value2, "problemname");
            return (Criteria) this;
        }

        public Criteria andProblemnameNotBetween(String value1, String value2) {
            addCriterion("problemname not between", value1, value2, "problemname");
            return (Criteria) this;
        }

        public Criteria andSolvestatusIsNull() {
            addCriterion("solvestatus is null");
            return (Criteria) this;
        }

        public Criteria andSolvestatusIsNotNull() {
            addCriterion("solvestatus is not null");
            return (Criteria) this;
        }

        public Criteria andSolvestatusEqualTo(String value) {
            addCriterion("solvestatus =", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusNotEqualTo(String value) {
            addCriterion("solvestatus <>", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusGreaterThan(String value) {
            addCriterion("solvestatus >", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusGreaterThanOrEqualTo(String value) {
            addCriterion("solvestatus >=", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusLessThan(String value) {
            addCriterion("solvestatus <", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusLessThanOrEqualTo(String value) {
            addCriterion("solvestatus <=", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusLike(String value) {
            addCriterion("solvestatus like", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusNotLike(String value) {
            addCriterion("solvestatus not like", value, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusIn(List<String> values) {
            addCriterion("solvestatus in", values, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusNotIn(List<String> values) {
            addCriterion("solvestatus not in", values, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusBetween(String value1, String value2) {
            addCriterion("solvestatus between", value1, value2, "solvestatus");
            return (Criteria) this;
        }

        public Criteria andSolvestatusNotBetween(String value1, String value2) {
            addCriterion("solvestatus not between", value1, value2, "solvestatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}