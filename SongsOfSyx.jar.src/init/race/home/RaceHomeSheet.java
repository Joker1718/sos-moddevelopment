/*    */ package init.race.home;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import init.resources.RES_AMOUNT;
/*    */ import init.sprite.game.SheetType;
/*    */ import init.sprite.game.Sheets;
/*    */ import java.io.IOException;
/*    */ import settlement.room.home.HOME;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ public final class RaceHomeSheet
/*    */ {
/*    */   private final int[][] needed;
/*    */   private Sheets[] ani;
/*    */   
/*    */   RaceHomeSheet() throws IOException {
/* 21 */     this.needed = Alloc.i2(0, 0);
/* 22 */     this.ani = new Sheets[0];
/*    */   }
/*    */ 
/*    */   
/*    */   RaceHomeSheet(LIST<RES_AMOUNT> resources, Json json, String key, SheetType it) throws IOException {
/* 27 */     if (!json.has(key)) {
/* 28 */       this.needed = Alloc.i2(0, 0);
/* 29 */       this.ani = new Sheets[0];
/*    */     } else {
/* 31 */       Json[] jsons = json.jsons(key);
/* 32 */       this.needed = Alloc.i2(jsons.length, resources.size());
/* 33 */       this.ani = new Sheets[jsons.length];
/*    */       
/* 35 */       for (int i = 0; i < jsons.length; i++) {
/* 36 */         Json j = jsons[i];
/* 37 */         addResource(resources, j, i, this.needed);
/* 38 */         this.ani[i] = new Sheets(it, j);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   static void addResource(LIST<RES_AMOUNT> resources, Json json, int i, int[][] needed) {
/* 44 */     Json j = json.json("RESOURCES");
/* 45 */     for (String k : j.keys()) {
/* 46 */       RESOURCE res = (RESOURCE)RESOURCES.map().tryGet(k);
/* 47 */       if (res != null) {
/* 48 */         for (int ri = 0; ri < resources.size(); ri++) {
/* 49 */           if (((RES_AMOUNT)resources.get(ri)).resource() == res) {
/* 50 */             needed[i][ri] = j.i(k, 0, 15);
/*    */           }
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public Sheets get(HOME data) {
/* 58 */     for (int ai = this.ani.length - 1; ai >= 0; ai--) {
/* 59 */       int[] amounts = this.needed[ai];
/* 60 */       int i = 0; while (true) { if (i >= amounts.length)
/*    */         {
/*    */ 
/*    */           
/* 64 */           return this.ani[ai]; }  if (data.resourceAm(i) < amounts[i])
/*    */           break;  i++; } 
/* 66 */     }  return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\home\RaceHomeSheet.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */