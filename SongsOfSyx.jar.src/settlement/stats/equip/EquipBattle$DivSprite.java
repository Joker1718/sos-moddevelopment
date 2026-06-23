/*     */ package settlement.stats.equip;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DivSprite
/*     */ {
/* 148 */   public int ox = 0;
/* 149 */   public int oy = 0;
/* 150 */   public int z = 0;
/* 151 */   public SPRITE icon = (SPRITE)(UI.icons()).s.cancel;
/* 152 */   public LIST<ColorImp> cols = (LIST<ColorImp>)new ArrayListGrower();
/*     */   
/*     */   public void read(Json json) throws IOException {
/* 155 */     this.ox = json.i("X", -100, 100, 0);
/* 156 */     this.oy = json.i("Y", -100, 100, 0);
/* 157 */     this.z = json.i("Z", -100, 100, 0);
/* 158 */     this.icon = (SPRITE)UI.icons().get(json, (Icon)(UI.icons()).s.cancel);
/* 159 */     this.cols = ColorImp.cols(json);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\EquipBattle$DivSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */