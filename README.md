<a name="bakeyourbread"></a>
# <img height='48' align=right src="./src/main/resources/icon.png"> <p align="center">&emsp;&emsp;&emsp; Bake Your Bread <sub><a title="Bake Your Bread on Modrinth" href="https://www.modrinth.com/mod/bakeyourbread"><img width="40" src="https://img.shields.io/badge/-%20-%230f91?style=flat&logo=modrinth"></a></sub> <a title="Bake Your Bread on Curseforge" href="https://www.curseforge.com/minecraft/mc-mods/bakeyourbread"><sub><img width="40" src="https://img.shields.io/badge/--%23f062?style=flat&logo=curseforge"></sub></a> </p>
> <img align=left height="153" src="https://raw.githubusercontent.com/pnk2u/resources/main/ModProjects/Bake-Your-Bread/pres/logo/logo_c.png">  
>  A mod adding variants for Minecraft's Food. <br><br><br><br>  
> <br>  
> <br>  
> <br>  


<a name="compatibility"></a>
### <img height="24" align="left" src="https://raw.githubusercontent.com/pnk2u/resources/main/ModProjects/shared/pres/icon/puzzle.svg"> Compatibility

<table>
  <thead>
    <tr>
      <td><strong>Minecraft</strong></td>
      <td>
        <a href="https://modrinth.com/mod/bakeyourbread/versions?g=1.20.1"><code>1.20.1</code></a><br>
        <a href="https://modrinth.com/mod/bakeyourbread/versions?g=1.21&g=1.21.1"><code>1.21(.1)</code></a>, <a href="https://modrinth.com/mod/bakeyourbread/versions?g=1.21.4&g=1.21.5&g=1.21.6&g=1.21.7&g=1.21.8&g=1.21.9&g=1.21.10?g=1.21.11"><code>1.21.4</code>~<code>1.21.11</code></a>
      </td>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Mod Loaders</strong></td>
      <td><sub><img width="16" src="https://raw.githubusercontent.com/FabricMC/fabric/1.21.10/src/main/resources/assets/fabric/icon.png"></sub><a href="https://fabricmc.net/use/installer/"><code>Fabric Loader</code></a></td>
    </tr>
  </tbody>
  <thead>
    <tr>
      <td><strong>Requires</strong></td>
      <td>
        <a href="https://modrinth.com/mod/fabric-api"><sub><img width="16" src="https://raw.githubusercontent.com/FabricMC/fabric/1.21.10/src/main/resources/assets/fabric/icon.png"></sub><code>Fabric API</code></a>
      </td>
    </tr>
  </thead>
</table>
<br>

<a name="translations"></a>
### <img height="24" align="left" src="https://raw.githubusercontent.com/pnk2u/resources/main/ModProjects/shared/pres/icon/translate.svg"> Translations

Currently available in:
- English
- German
- Ukrainian (@[StarmanMine142](/../../../../StarmanMine142) with [PR #3](../../pull/3)/[4](../../pull/4), added in [`1.1.2`](./CHANGELOG_history.md#1.1.2))

> [!NOTE]
> > Want to help translate? If you can, please open a PR to the **default branch** [`1.21(.1)`](../../tree/1.21(.1)).  
> > Otherwise, simply send your translation via email (contact@pnku.de) or join the [Discord](https://discord.lieonlion.dev).

<br>


<img height="53" align="left" src="https://raw.githubusercontent.com/pnk2u/resources/main/ModProjects/shared/pres/icon/changelog.svg">  

### Versions
<a name="most-recent-version"></a>
<!--CHANGELOG:START-->
<a name="1.3.0"></a>
### 1.3.0[*](#footnote-*):
- Add _**Raw** (Golden) Carrots_ (suggested by <ins>Special_TT</ins> (&#x200A;<sub><a title="Special_TT&#10;on Modrinth" href="https://modrinth.com/user/special_tt"><img width=20 src="https://img.shields.io/badge/-%20-%23032a?style=flat&logo=modrinth"></a></sub><!--SEPARATOR_V:GH--><img width=7 height=10 src="https://raw.githubusercontent.com/pnk2u/resources/main/ModProjects/shared/pres/icon/separator_v.svg"><sub><a title="Special_TT&#10;on Curseforge" href="https://www.curseforge.com/members/special_tt"><img width=20 src="https://img.shields.io/badge/--%23302a?style=flat&logo=curseforge"></a></sub>&#x200A;), author of <ins>Cooked Carrot</ins> (&#x200A;<sub><a title="Cooked Carrot&#10;on Modrinth" href="https://modrinth.com/datapack/cooked-carrot/"><img width=20 src="https://img.shields.io/badge/-%20-%23032a?style=flat&logo=modrinth"></a></sub>&#x200A;)) 
  - _**Raw** Carrots_ are dropped when breaking fully grown _Carrot_ crops
  - _**Raw** (Golden) Carrots_ have lower nutrition and saturation values than their cooked counterparts similar to _Potatoes_ \<\-\> _Baked Potatoes_
  - _**Raw** (Golden) Carrots_ can be cooked in a Furnace, Smoker or on a Campfire to get _**Cooked** (Golden) Carrots_ which have the same nutrition and saturation values as regular _Carrots_ and _Golden Carrots_
  - Both _**Raw**_ and _**Cooked** Carrots_ can be used to feed and breed/attract pigs  
    and as ingredients for the _Carrot on a Stick_ recipe
  - Only _**Raw** (Golden) Carrots_ can be used to feed and breed/attract rabbits
  - Both _**Raw**_ and _**Cooked** Golden Carrots_ can be used to feed and breed/attract horses, donkeys and mules
    - `1.21.6+`: _**Raw**_ and _**Cooked** Carrots_ can be used for the same purpose
      > (Mirroring the change to Vanilla in <ins>1.21.6</ins>)
  - Both _**Raw**_ and _**Cooked** Carrots_ can be used to craft _**Uncooked** Rabbit Stew_
  - _**Raw** Golden Carrots_ can be crafted using _**Raw** Carrots_
  - _**Cooked** Golden Carrots_ can be crafted using _**Cooked** Carrots_
- _**Unbaked** Cake_ can now be placed like regular _Cake_ but just like the _**Unbaked Cake**_ item, it will restore much less hunger and saturation than _**Baked** Cake_
  - _**Unbaked**_ and regular _Cakes_ now drop themselves when broken at zero slices eaten  
    > If any slices have been eaten, they don't drop anything when broken, just like Vanilla.
  - _**Unbaked** Cake_ as an Item can now only be eaten when holding down the Sneak/Shift Key 
- All **Raw**/**Uncooked**/**Unbaked** items can now be put in the composter
    > _Soups_ and _Stews_ return the Bowl.
- Add several **Raw**/**Uncooked**/**Unbaked** items to relevant `#c:item_tags`:
  - `#c:foods/edible_when_placed`: _**Unbaked** Cake_
  - `#c:foods/food_poisoning`: _Bread **Dough**_, _Cookie **Dough**_, _Pumpkin Pie **Dough**_, _**Unbaked** Cake_, _**Uncooked** Rabbit Stew_
  - `#c:foods/soup`: _**Uncooked** Beetroot Soup_, _**Uncooked** Mushroom Stew_
  - `#c:foods/vegetable`: _**Raw** Carrot_, _**Raw** Golden Carrot_

<sub>License changed to [CC-BY-NC-SA-4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/) (previously [MIT](https://opensource.org/licenses/MIT))</sub>

<h2><sub><sub><sup><ins>Download 1.3.0 + 1.21(.1)</ins>:</sup>&#x200A;
<a title="Download (Modrinth):&#10;Bake Your Bread 1.3.0 + 1.21(.1)" href="https://www.modrinth.com/mod/4cgX9zXl/version/mAs7jEqD">
<img width=26 src="https://img.shields.io/badge/-%20-%23032a?style=flat&logo=modrinth"></a>
<sup><img width=7 height=10 src="https://raw.githubusercontent.com/pnk2u/resources/main/ModProjects/shared/pres/icon/separator_v.svg"></sup>
<a title="Download (Curseforge):&#10;1.3.0 + 1.21(.1) - Bake Your Bread" href="https://www.curseforge.com/minecraft/mc-mods/bakeyourbread/files/7690328">
<img width=26 src="https://img.shields.io/badge/--%23302a?style=flat&logo=curseforge"></a>
</sub></sub></h2>

<!--CHANGELOG:END-->
<a name="footnote-*"></a>
> <strong>*</strong><sup>: Most recent version</sup>  
> _`The version above is automatically updated with the newest release and only after it has been successfully published.`_

<a name="changelog-history"></a>
> [!TIP]
> > Looking for changes of previous versions?  
> > You can find them in the [changelog history](./CHANGELOG_history.md).

---
#### Support/Contact
- Suggestions? Questions? Bug reports?  
  Feel free to [open an issue](/../../issues)!  
  &nbsp;  
  You can also contact me via email at [contact@pnku.de](mailto:contact@pnku.de) or join the [Discord](https://dsc.lieonlion.dev) and contact me there.