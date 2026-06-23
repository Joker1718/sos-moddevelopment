/*     */ package world.entity;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.slider.GAllocator;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ import world.entity.haven.WHaven;
/*     */ import world.entity.haven.WHavenType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Placers
/*     */   extends ArrayListGrower<PLACABLE>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Placers(LIST<WHavenType> types) {
/*  37 */     final PlacableSimpleTile undo = new PlacableSimpleTile("camps remove")
/*     */       {
/*     */         public void place(int tx, int ty)
/*     */         {
/*  41 */           for (WHaven h : (WORLD.ENTITIES()).havens.fillTile(tx, ty)) {
/*  42 */             h.delete();
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/*  48 */           return ((WORLD.ENTITIES()).havens.fillTile(tx, ty).size() > 0) ? null : E;
/*     */         }
/*     */       };
/*     */     
/*  52 */     final GETTER.GETTER_IMP<WHavenType> type = new GETTER.GETTER_IMP(types.get(0));
/*     */     
/*  54 */     GuiSection s = new GuiSection();
/*  55 */     for (WHavenType t : types) {
/*  56 */       s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  60 */               type.set(t);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/*  65 */               this.label = (SPRITE)(t.race.appearance()).icon;
/*  66 */               selectedSet((type.get() == t));
/*     */             }
/*  69 */           }).hoverInfoSet(t.race.info.names));
/*     */     } 
/*     */     
/*  72 */     final INT.INTE inte = new INT.INTE()
/*     */       {
/*  74 */         int i = 0;
/*     */ 
/*     */         
/*     */         public int min() {
/*  78 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/*  83 */           return 8;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/*  88 */           return this.i;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/*  93 */           this.i = t;
/*     */         }
/*     */       };
/*     */     
/*  97 */     s.addRelBody(2, DIR.S, (RENDEROBJ)new GAllocator(COLOR.RED100, inte, 6, 16));
/*     */     
/*  99 */     final ArrayList<CLICKABLE> ss = new ArrayList(s);
/*     */     
/* 101 */     add(new PlacableSimpleTile("camps")
/*     */         {
/*     */           public CharSequence isPlacable(int tx, int ty) {
/* 104 */             return null;
/*     */           }
/*     */           
/* 107 */           int ni = 0;
/*     */ 
/*     */           
/*     */           public void place(int tx, int ty) {
/* 111 */             CharSequence nn = (CharSequence)((WHavenType)type.get()).names.getC(this.ni++);
/*     */             
/* 113 */             Str.TMP.clear().add(nn);
/* 114 */             Str.TMP.insert(0, (CharSequence)(((WHavenType)type.get()).race.appearance()).lastNamesNoble.getC(RND.rInt(65535)));
/*     */             
/* 116 */             (WORLD.ENTITIES()).havens.create(tx, ty, (WHavenType)type.get(), inte.getD(), nn);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public LIST<CLICKABLE> getAdditionalButt() {
/* 122 */             return (LIST<CLICKABLE>)ss;
/*     */           }
/*     */ 
/*     */           
/*     */           public PLACABLE getUndo() {
/* 127 */             return (PLACABLE)undo;
/*     */           }
/*     */ 
/*     */           
/*     */           public SPRITE getIcon() {
/* 132 */             return (SPRITE)(((WHavenType)(WORLD.ENTITIES()).havens.types.get(0)).race.appearance()).icon;
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\Placers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */