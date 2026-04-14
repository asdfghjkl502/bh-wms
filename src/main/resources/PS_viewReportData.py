# -*- coding: utf-8 -*-
import json
import os
import time

import jwt
import requests


# ==============================
# 基础配置
# ==============================
APP_ID = "请替换为实际APP_ID"
ACCESS_TOKEN = "请替换为实际ACCESS_TOKEN"
USERNAME = "请替换为实际用户名"

# local / online_cn / online_sgp
TARGET_ENV = "cn"
ONLINE_CN_BASE_URL = "https://api.perfsight.qq.com"
ONLINE_SGP_BASE_URL = "https://api.perfsight.wetest.net"


# ==============================
# 业务参数
# ==============================
VIEW_NAME = "请替换为实际模板名称"
PLATFORM = 5  # 0-Android, 1-iOS, 5-PC
VERSION_LIST = ["请替换为实际版本号"]
STIME = "2026-04-13 00:00:00"
ETIME = "2026-04-13 23:59:59"
ARCHIVE = "year"  # all/year/week/day/hour
SOURCE = 0
IS_PERIOD = False

# 可选场景过滤。多个场景是“或”关系，不支持“且”。
SCENE_NAMES = []

# 画质传参二选一:
# 1. USE_CUSTOMIZE_ARR = True  时，仅传 customizeArr
# 2. USE_CUSTOMIZE_ARR = False 时，仅传 customizeClassArr
USE_CUSTOMIZE_ARR = False

CUSTOMIZE_ARR = [
    {"CategoryId": 2, "CategoryItemId": 28},
    {"CategoryId": 1, "CategoryItemId": 13},
]

CUSTOMIZE_CLASS_ARR = [
    {"category": "分类名示例1", "category_items": ["取值示例1"]},
    {"category": "分类名示例2", "category_items": ["取值示例2"]},
]


def get_base_url():
    if TARGET_ENV == "cn":
        return ONLINE_CN_BASE_URL
    if TARGET_ENV == "sgp":
        return ONLINE_SGP_BASE_URL
    raise ValueError(f"unsupported TARGET_ENV: {TARGET_ENV}")


def build_filters():
    filters = {
        "app_version": VERSION_LIST,
    }
    if SCENE_NAMES:
        filters["scene_name"] = SCENE_NAMES
    return filters


def build_payload():
    payload = {
        "exp": int(time.time() + 12000),
        "viewName": VIEW_NAME,
        "version": VERSION_LIST,
        "aggres": [],
        "archive": ARCHIVE,
        "filters": build_filters(),
        "isCustomize": bool(CUSTOMIZE_ARR or CUSTOMIZE_CLASS_ARR),
        "isPeriod": IS_PERIOD,
        "stime": STIME,
        "etime": ETIME,
        "platform": PLATFORM,
        "source": SOURCE,
        "requestid": USERNAME + "_viewReportData",
        "userName": USERNAME,
    }

    if USE_CUSTOMIZE_ARR:
        payload["customizeArr"] = CUSTOMIZE_ARR
    else:
        payload["customizeClassArr"] = CUSTOMIZE_CLASS_ARR

    return payload


def main():
    payload = build_payload()

    jwt_token = jwt.encode(
        payload=payload,
        key=ACCESS_TOKEN,
        algorithm="HS256",
        headers={"alg": "HS256", "typ": "JWT"},
    )

    params = {
        "app_id": APP_ID,
        "username": USERNAME,
        "token": jwt_token,
    }

    url = get_base_url() + "/openapi/common/viewReportData"

    print("Token:", jwt_token[:50] + "...")
    print(f"\n请求URL: {url}")
    print(f"请求参数: {json.dumps(params, ensure_ascii=False, indent=2)}")
    print(f"\nJWT业务参数: {json.dumps(payload, ensure_ascii=False, indent=2)}")

    response = requests.post(url, json=params, headers={"Content-Type": "application/json"})
    print(f"\nHTTP状态码: {response.status_code}")

    result = response.json()
    print("\n返回结果:")
    print(json.dumps(result, ensure_ascii=False, indent=2))

    script_name = os.path.splitext(os.path.basename(__file__))[0]
    output_path = os.path.join(os.path.dirname(__file__), "output", f"{script_name}.json")
    os.makedirs(os.path.dirname(output_path), exist_ok=True)
    with open(output_path, "w", encoding="utf-8") as f:
        json.dump(result, f, ensure_ascii=False, indent=2)

    print(f"\n结果已保存到 {output_path}")


if __name__ == "__main__":
    main()
