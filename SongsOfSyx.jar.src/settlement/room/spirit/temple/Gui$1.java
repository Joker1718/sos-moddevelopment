/*    */ package settlement.room.spirit.temple;
/*    */ 
/*    */ import init.type.HTYPES;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 55 */     GFORMAT.perc(text, ((TempleInstance)getter.get()).sacrificeValue());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 61 */     GText t = b.text();
/* 62 */     t.add(Gui.¤¤SacrificingD);
/* 63 */     t.insert(0, ((TempleInstance)getter.get()).jobs.size() * (((TempleInstance)getter.get()).blueprintI()).STIME * 0.5D, 2);
/* 64 */     b.add((SPRITE)t);
/*    */     
/* 66 */     b.NL(8);
/* 67 */     if (((ROOM_TEMPLE)Gui.access$2(Gui.this)).altar instanceof TempleAltar.Resource) {
/* 68 */       t = b.text();
/* 69 */       t.add(Gui.¤¤SacrificingResource);
/* 70 */       t.insert(0, ((ROOM_TEMPLE)Gui.access$2(Gui.this)).resource.name);
/* 71 */       b.add((SPRITE)t);
/* 72 */     } else if (((ROOM_TEMPLE)Gui.access$2(Gui.this)).altar instanceof TempleAltar.Animal) {
/* 73 */       t = b.text();
/* 74 */       t.add(Gui.¤¤SacrificingAnimal);
/* 75 */       t.insert(0, ((ROOM_TEMPLE)Gui.access$2(Gui.this)).resource.name);
/* 76 */       b.add((SPRITE)t);
/* 77 */     } else if (((ROOM_TEMPLE)Gui.access$2(Gui.this)).altar instanceof TempleAltar.Prisoner) {
/* 78 */       t = b.text();
/* 79 */       t.add(Gui.¤¤SacrificingHuman);
/* 80 */       t.insert(0, STATS.POP().pop(HTYPES.PRISONER()));
/* 81 */       b.add((SPRITE)t);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */