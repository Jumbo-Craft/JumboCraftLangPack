# This is a sample Python script.
import json


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def main():
    # Use a breakpoint in the code line below to debug your script.
    lang = 'de_de'
    fragment = 'fragment'

    original_json = json.load(open(f'./input/{lang}.json','r',encoding='utf-8'))
    output_json = {}
    frag_blocks = json.load(open('./input/fragment_block.json','r'))['blocks']

    for block in frag_blocks:
        display_name = original_json[f'block.minecraft.{block}']
        output_json[f'block.jumbo_craft.{block}_fragment'] = f'{display_name}{fragment}'

    path = f'./output/{lang}.json'
    with open(path, mode='w', encoding='utf-8') as f:
        json.dump(output_json, f, ensure_ascii=False, indent=4, sort_keys=True, separators=(',', ': '))

    print(f'saved: {path}')


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
