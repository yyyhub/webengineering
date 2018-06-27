package cn.yyy.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReleaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReleaseExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andReleaseidIsNull() {
            addCriterion("releaseid is null");
            return (Criteria) this;
        }

        public Criteria andReleaseidIsNotNull() {
            addCriterion("releaseid is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseidEqualTo(Integer value) {
            addCriterion("releaseid =", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotEqualTo(Integer value) {
            addCriterion("releaseid <>", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThan(Integer value) {
            addCriterion("releaseid >", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("releaseid >=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThan(Integer value) {
            addCriterion("releaseid <", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThanOrEqualTo(Integer value) {
            addCriterion("releaseid <=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidIn(List<Integer> values) {
            addCriterion("releaseid in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotIn(List<Integer> values) {
            addCriterion("releaseid not in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidBetween(Integer value1, Integer value2) {
            addCriterion("releaseid between", value1, value2, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("releaseid not between", value1, value2, "releaseid");
            return (Criteria) this;
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

        public Criteria andReleasetimeIsNull() {
            addCriterion("releasetime is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("releasetime is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("releasetime >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(Date value) {
            addCriterionForJDBCDate("releasetime <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("releasetime <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterionForJDBCDate("releasetime in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("releasetime not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("releasetime between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("releasetime not between", value1, value2, "releasetime");
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