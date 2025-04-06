import os
import requests
import pprint


def read_api_key():
    with open(os.getenv("DATA_API_KEY_PATH")) as f:
        return f.read()

def extract_video_id(url: str) -> str:
    return url.split('v=')[-1]

class DataApiClient:
    def __init__(self):
        self.api_key = read_api_key()

    def get_video_statistics(self, video_id: str):
        endpoint = f"https://www.googleapis.com/youtube/v3/videos?part=contentDetails,statistics,snippet&id={video_id}&key={self.api_key}"
        res = requests.get(endpoint)
        return res.json()
    
    def search(keyword: list[str]):
        part = "snippet"
        


def request_api(url: str):
    video_id = extract_video_id(url)
    api_key = read_api_key()
    endpoint = f"https://www.googleapis.com/youtube/v3/videos?part=contentDetails,statistics,snippet&id={video_id}&key={api_key}"
    print("get request to: ", endpoint)
    res = requests.get(endpoint)
    pprint.pprint(res.json())


if __name__ == '__main__':
    client = DataApiClient()
    stats = client.get_video_statistics('LWcafj0rhkA')
    pprint.pprint(stats)
    # request_api('https://www.youtube.com/watch?v=LWcafj0rhkA')
    # print(os.getenv("DATA_API_KEY_PATH"))