package cn.yyy.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExample() {
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

        public Criteria andJobidIsNull() {
            addCriterion("jobid is null");
            return (Criteria) this;
        }

        public Criteria andJobidIsNotNull() {
            addCriterion("jobid is not null");
            return (Criteria) this;
        }

        public Criteria andJobidEqualTo(Integer value) {
            addCriterion("jobid =", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotEqualTo(Integer value) {
            addCriterion("jobid <>", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThan(Integer value) {
            addCriterion("jobid >", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThanOrEqualTo(Integer value) {
            addCriterion("jobid >=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThan(Integer value) {
            addCriterion("jobid <", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThanOrEqualTo(Integer value) {
            addCriterion("jobid <=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidIn(List<Integer> values) {
            addCriterion("jobid in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotIn(List<Integer> values) {
            addCriterion("jobid not in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidBetween(Integer value1, Integer value2) {
            addCriterion("jobid between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotBetween(Integer value1, Integer value2) {
            addCriterion("jobid not between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentid is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentid is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("studentid =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("studentid <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("studentid >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentid >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("studentid <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("studentid <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("studentid in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("studentid not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("studentid between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("studentid not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Integer> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Integer> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNull() {
            addCriterion("jobname is null");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNotNull() {
            addCriterion("jobname is not null");
            return (Criteria) this;
        }

        public Criteria andJobnameEqualTo(String value) {
            addCriterion("jobname =", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotEqualTo(String value) {
            addCriterion("jobname <>", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThan(String value) {
            addCriterion("jobname >", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThanOrEqualTo(String value) {
            addCriterion("jobname >=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThan(String value) {
            addCriterion("jobname <", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThanOrEqualTo(String value) {
            addCriterion("jobname <=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLike(String value) {
            addCriterion("jobname like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotLike(String value) {
            addCriterion("jobname not like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameIn(List<String> values) {
            addCriterion("jobname in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotIn(List<String> values) {
            addCriterion("jobname not in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameBetween(String value1, String value2) {
            addCriterion("jobname between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotBetween(String value1, String value2) {
            addCriterion("jobname not between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNull() {
            addCriterion("submittime is null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNotNull() {
            addCriterion("submittime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeEqualTo(Date value) {
            addCriterion("submittime =", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotEqualTo(Date value) {
            addCriterion("submittime <>", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThan(Date value) {
            addCriterion("submittime >", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submittime >=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThan(Date value) {
            addCriterion("submittime <", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThanOrEqualTo(Date value) {
            addCriterion("submittime <=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIn(List<Date> values) {
            addCriterion("submittime in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotIn(List<Date> values) {
            addCriterion("submittime not in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeBetween(Date value1, Date value2) {
            addCriterion("submittime between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotBetween(Date value1, Date value2) {
            addCriterion("submittime not between", value1, value2, "submittime");
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