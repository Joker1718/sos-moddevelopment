/*    */ package settlement.room.main.util;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import java.nio.file.Path;
/*    */ import settlement.room.main.ROOMS;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ public class RoomInitData
/*    */ {
/* 12 */   private PATH gData = PATHS.INIT().getFolder("room");
/* 13 */   private PATH gText = PATHS.TEXT().getFolder("room");
/* 14 */   public final PATH gSprite = PATHS.SPRITE().getFolder("room");
/*    */   
/*    */   private Json data;
/*    */   private Json text;
/*    */   private String key;
/*    */   private String type;
/*    */   public final ROOMS m;
/*    */   
/*    */   public RoomInitData(ROOMS m) {
/* 23 */     this.m = m;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 28 */     return this.key;
/*    */   }
/*    */   
/*    */   public Json data() {
/* 32 */     return this.data;
/*    */   }
/*    */   
/*    */   public Json text() {
/* 36 */     return this.text;
/*    */   }
/*    */   
/*    */   public Path sp() {
/* 40 */     return this.gSprite.get(this.key);
/*    */   }
/*    */   
/*    */   public Path sp(String type, String key) {
/* 44 */     return this.gSprite.get(key);
/*    */   }
/*    */   
/*    */   public String type() {
/* 48 */     return this.type;
/*    */   }
/*    */   
/*    */   public RoomInitData init(String key) {
/* 52 */     this.data = new Json(this.gData.gets(key));
/* 53 */     this.text = new Json(this.gText.gets(key));
/* 54 */     this.key = key;
/* 55 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public PATH getter() {
/* 60 */     return this.gData;
/*    */   }
/*    */   
/*    */   public RoomInitData setType(String type) {
/* 64 */     this.type = type;
/* 65 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomInitData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */