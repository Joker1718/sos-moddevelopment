/*    */ package init.tech;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.sprite.SPRITES;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TechTree
/*    */ {
/*    */   public final COLOR color;
/*    */   public final SPRITE icon;
/*    */   public final TECH[][] nodes;
/*    */   public final String key;
/*    */   public final CharSequence name;
/*    */   public final int cat;
/*    */   
/*    */   TechTree(TechCurrency.TechCurrencies cc, String key, Json jData, Json jText, LISTE<TECH> all) throws IOException {
/* 24 */     this.key = key;
/*    */     
/* 26 */     this.color = (COLOR)new ColorImp(jData);
/* 27 */     this.cat = jData.i("CATEGORY", 0, 5, 0);
/* 28 */     this.name = jText.text("NAME");
/* 29 */     this.icon = (SPRITE)SPRITES.icons().get(jData);
/* 30 */     Json rows = jData.json("TREE");
/*    */     
/* 32 */     Json techs = jData.has("TECHS") ? jData.json("TECHS") : null;
/* 33 */     Json texts = jText.has("TECHS") ? jText.json("TECHS") : null;
/*    */     
/* 35 */     this.nodes = new TECH[rows.keys().size()][];
/* 36 */     int ri = 0;
/*    */     
/* 38 */     for (String __ : rows.keys()) {
/* 39 */       String[] values = rows.values(__);
/* 40 */       this.nodes[ri] = new TECH[values.length];
/*    */       
/* 42 */       for (int ci = 0; ci < values.length; ci++) {
/* 43 */         String v = values[ci];
/* 44 */         if (!v.equals("_____") && !v.equals("______")) {
/*    */           Json data, text;
/*    */ 
/*    */           
/* 48 */           if (techs != null && techs.has(v)) {
/* 49 */             data = techs.json(v);
/* 50 */             text = texts.has(v) ? texts.json(v) : null;
/*    */           } else {
/* 52 */             GAME.Warn(rows.errorGet("there is no tech in the nodes folder named: " + v, v));
/*    */             ci++;
/*    */           } 
/* 55 */           TECH t = new TECH(cc, this.key + "_" + this.key, all, data, text, this, ci, ri);
/* 56 */           this.nodes[ri][ci] = t;
/*    */         } 
/*    */       } 
/*    */ 
/*    */       
/* 61 */       ri++;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TechTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */