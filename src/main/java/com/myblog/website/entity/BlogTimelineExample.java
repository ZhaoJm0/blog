package com.myblog.website.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BlogTimelineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogTimelineExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNull() {
            addCriterion("event_name is null");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNotNull() {
            addCriterion("event_name is not null");
            return (Criteria) this;
        }

        public Criteria andEventNameEqualTo(String value) {
            addCriterion("event_name =", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotEqualTo(String value) {
            addCriterion("event_name <>", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThan(String value) {
            addCriterion("event_name >", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThanOrEqualTo(String value) {
            addCriterion("event_name >=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThan(String value) {
            addCriterion("event_name <", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThanOrEqualTo(String value) {
            addCriterion("event_name <=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLike(String value) {
            addCriterion("event_name like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotLike(String value) {
            addCriterion("event_name not like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameIn(List<String> values) {
            addCriterion("event_name in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotIn(List<String> values) {
            addCriterion("event_name not in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameBetween(String value1, String value2) {
            addCriterion("event_name between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotBetween(String value1, String value2) {
            addCriterion("event_name not between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventContentIsNull() {
            addCriterion("event_content is null");
            return (Criteria) this;
        }

        public Criteria andEventContentIsNotNull() {
            addCriterion("event_content is not null");
            return (Criteria) this;
        }

        public Criteria andEventContentEqualTo(String value) {
            addCriterion("event_content =", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentNotEqualTo(String value) {
            addCriterion("event_content <>", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentGreaterThan(String value) {
            addCriterion("event_content >", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentGreaterThanOrEqualTo(String value) {
            addCriterion("event_content >=", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentLessThan(String value) {
            addCriterion("event_content <", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentLessThanOrEqualTo(String value) {
            addCriterion("event_content <=", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentLike(String value) {
            addCriterion("event_content like", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentNotLike(String value) {
            addCriterion("event_content not like", value, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentIn(List<String> values) {
            addCriterion("event_content in", values, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentNotIn(List<String> values) {
            addCriterion("event_content not in", values, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentBetween(String value1, String value2) {
            addCriterion("event_content between", value1, value2, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventContentNotBetween(String value1, String value2) {
            addCriterion("event_content not between", value1, value2, "eventContent");
            return (Criteria) this;
        }

        public Criteria andEventDateIsNull() {
            addCriterion("event_date is null");
            return (Criteria) this;
        }

        public Criteria andEventDateIsNotNull() {
            addCriterion("event_date is not null");
            return (Criteria) this;
        }

        public Criteria andEventDateEqualTo(Date value) {
            addCriterionForJDBCDate("event_date =", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("event_date <>", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateGreaterThan(Date value) {
            addCriterionForJDBCDate("event_date >", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("event_date >=", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateLessThan(Date value) {
            addCriterionForJDBCDate("event_date <", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("event_date <=", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateIn(List<Date> values) {
            addCriterionForJDBCDate("event_date in", values, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("event_date not in", values, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("event_date between", value1, value2, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("event_date not between", value1, value2, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventTimeIsNull() {
            addCriterion("event_time is null");
            return (Criteria) this;
        }

        public Criteria andEventTimeIsNotNull() {
            addCriterion("event_time is not null");
            return (Criteria) this;
        }

        public Criteria andEventTimeEqualTo(Date value) {
            addCriterionForJDBCTime("event_time =", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("event_time <>", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("event_time >", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("event_time >=", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeLessThan(Date value) {
            addCriterionForJDBCTime("event_time <", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("event_time <=", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeIn(List<Date> values) {
            addCriterionForJDBCTime("event_time in", values, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("event_time not in", values, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("event_time between", value1, value2, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("event_time not between", value1, value2, "eventTime");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
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