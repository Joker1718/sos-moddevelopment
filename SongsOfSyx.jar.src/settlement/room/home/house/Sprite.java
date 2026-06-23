/*    */ package settlement.room.home.house;
/*    */ 
/*    */ import init.race.home.RaceHomeClass;
/*    */ import init.sprite.game.Sheets;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ abstract class Sprite
/*    */   extends RoomSprite.Imp {
/*    */   public final boolean service;
/*    */   public final boolean bed;
/*    */   public final boolean solid;
/*    */   HomeInstance house;
/*    */   
/*    */   public Sprite(boolean service, boolean bed, boolean solid) {
/* 23 */     this.service = service;
/* 24 */     this.bed = bed;
/* 25 */     this.solid = solid;
/*    */   }
/*    */   
/*    */   public Sprite() {
/* 29 */     this(false, false, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public DIR dir(int data) {
/* 34 */     return (DIR)DIR.ORTHO.get(data & 0x3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static abstract class Rot
/*    */     extends Sprite
/*    */   {
/*    */     Rot() {}
/*    */ 
/*    */     
/*    */     Rot(boolean service, boolean bed, boolean solid) {
/* 46 */       super(service, bed, solid);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 52 */       Sheets a = a(this.house.race().home().clas(this.house.occupant(0)));
/* 53 */       int ran = it.ran();
/* 54 */       Sprites.render1x1(ran, a, r, s, data, it, degrade);
/* 55 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 62 */       Room room = (SETT.ROOMS()).map.get(tx, ty);
/*    */       
/* 64 */       int r = RND.rInt(4); int i;
/* 65 */       for (i = 0; i < DIR.ORTHO.size(); i++) {
/* 66 */         int q = (i + r) % 4;
/* 67 */         DIR d = (DIR)DIR.ORTHO.getC(i + r);
/* 68 */         if (!room.isSame(tx, ty, tx + d.x(), ty + d.y())) {
/* 69 */           return (byte)q;
/*    */         }
/*    */       } 
/*    */       
/* 73 */       for (i = 0; i < DIR.ORTHO.size(); i++) {
/* 74 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 75 */         if (this.house.sprite(tx + d.x(), ty + d.y()) == (SETT.ROOMS()).HOME.constructor.sp.tabl) {
/* 76 */           return (byte)((i + 2) % 4);
/*    */         }
/*    */       } 
/*    */       
/* 80 */       return (byte)RND.rInt(4);
/*    */     }
/*    */ 
/*    */     
/*    */     abstract Sheets a(RaceHomeClass param1RaceHomeClass);
/*    */   }
/*    */   
/*    */   protected RaceHomeClass sp() {
/* 88 */     return this.house.race().home().clas(this.house.occupant(0));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\Sprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */