package cn.yyy.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(Integer value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(Integer value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(Integer value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(Integer value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(Integer value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<Integer> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<Integer> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(Integer value1, Integer value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(Integer value1, Integer value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNull() {
            addCriterion("taskname is null");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNotNull() {
            addCriterion("taskname is not null");
            return (Criteria) this;
        }

        public Criteria andTasknameEqualTo(String value) {
            addCriterion("taskname =", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotEqualTo(String value) {
            addCriterion("taskname <>", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThan(String value) {
            addCriterion("taskname >", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThanOrEqualTo(String value) {
            addCriterion("taskname >=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThan(String value) {
            addCriterion("taskname <", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThanOrEqualTo(String value) {
            addCriterion("taskname <=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLike(String value) {
            addCriterion("taskname like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotLike(String value) {
            addCriterion("taskname not like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameIn(List<String> values) {
            addCriterion("taskname in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotIn(List<String> values) {
            addCriterion("taskname not in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameBetween(String value1, String value2) {
            addCriterion("taskname between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotBetween(String value1, String value2) {
            addCriterion("taskname not between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherid is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherid is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherid =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherid <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherid >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherid >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherid <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherid <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherid in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherid not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherid between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherid not between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNull() {
            addCriterion("courseid is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseid is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("courseid =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("courseid <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("courseid >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseid >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("courseid <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("courseid <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("courseid in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("courseid not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("courseid between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("courseid not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andTaskcontentIsNull() {
            addCriterion("taskcontent is null");
            return (Criteria) this;
        }

        public Criteria andTaskcontentIsNotNull() {
            addCriterion("taskcontent is not null");
            return (Criteria) this;
        }

        public Criteria andTaskcontentEqualTo(String value) {
            addCriterion("taskcontent =", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentNotEqualTo(String value) {
            addCriterion("taskcontent <>", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentGreaterThan(String value) {
            addCriterion("taskcontent >", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentGreaterThanOrEqualTo(String value) {
            addCriterion("taskcontent >=", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentLessThan(String value) {
            addCriterion("taskcontent <", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentLessThanOrEqualTo(String value) {
            addCriterion("taskcontent <=", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentLike(String value) {
            addCriterion("taskcontent like", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentNotLike(String value) {
            addCriterion("taskcontent not like", value, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentIn(List<String> values) {
            addCriterion("taskcontent in", values, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentNotIn(List<String> values) {
            addCriterion("taskcontent not in", values, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentBetween(String value1, String value2) {
            addCriterion("taskcontent between", value1, value2, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andTaskcontentNotBetween(String value1, String value2) {
            addCriterion("taskcontent not between", value1, value2, "taskcontent");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
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