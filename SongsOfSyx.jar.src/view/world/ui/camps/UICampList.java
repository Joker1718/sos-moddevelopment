/*     */ package view.world.ui.camps;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import java.util.Comparator;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.haven.WHaven;
/*     */ import world.entity.haven.WHavenType;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UICampList
/*     */   extends ISidePanel
/*     */ {
/*  39 */   private final Rec hBody = new Rec(128.0D);
/*     */   
/*  41 */   private final ArrayListResize<WHaven> al = new ArrayListResize(256, 2048);
/*     */   
/*  43 */   private final Comparator<WHaven> sort = new Comparator<WHaven>()
/*     */     {
/*     */       public int compare(WHaven o1, WHaven o2)
/*     */       {
/*  47 */         return get(o1) - get(o2);
/*     */       }
/*     */       
/*     */       private int get(WHaven current) {
/*  51 */         int res = current.index();
/*  52 */         Faction f = current.faction();
/*  53 */         if (f != FACTIONS.player())
/*     */         {
/*  55 */           if (f == null && (WORLD.REGIONS()).map.get(current.ctx(), current.cty()) != null && ((Region)(WORLD.REGIONS()).map.get(current.ctx(), current.cty())).faction() == FACTIONS.player()) {
/*  56 */             res += 10000;
/*  57 */           } else if (f == null) {
/*  58 */             res += 20000;
/*     */           } else {
/*  60 */             res += 30000;
/*     */           }  } 
/*  62 */         return res;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private final GTableBuilder builder;
/*  68 */   private int upI = -1;
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
/*     */   public UICampList() {
/*  80 */     GuiSection s = new GuiSection();
/*     */     
/*  82 */     for (WHavenType t : (WORLD.camps()).types) {
/*  83 */       s.addDownC(4, (RENDEROBJ)new CampInfo(t));
/*     */     }
/*     */     
/*  86 */     this.section.add((RENDEROBJ)s);
/*     */     
/*  88 */     this.builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  92 */           return UICampList.this.all().size();
/*     */         }
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
/*     */         public void hover(int index) {}
/*     */       };
/* 106 */     this.builder.column(null, 290, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/* 110 */             return (RENDEROBJ)new UICampList.Button(ier);
/*     */           }
/*     */         });
/*     */     
/* 114 */     s = this.builder.createHeight(HEIGHT - this.section.body().height() - 4, true);
/* 115 */     this.section.addDown(2, (RENDEROBJ)s);
/*     */     
/* 117 */     titleSet((WORLD.camps()).info.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<WHaven> all() {
/* 122 */     if (this.upI == -1 || Math.abs(this.upI - GAME.updateI()) > 200) {
/* 123 */       this.upI = GAME.updateI();
/* 124 */       this.al.clearSoft();
/*     */       
/* 126 */       for (WEntity e : WORLD.ENTITIES().allSlow()) {
/* 127 */         if (this.al.hasRoom() && e instanceof WHaven) {
/* 128 */           this.al.add(e);
/*     */         }
/*     */       } 
/* 131 */       this.al.sort(this.sort);
/*     */     } 
/* 133 */     return (LIST<WHaven>)this.al;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(float ds) {}
/*     */ 
/*     */   
/*     */   private final class Button
/*     */     extends GuiSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */ 
/*     */     
/*     */     Button(final GETTER<Integer> ier) {
/* 147 */       this.ier = ier;
/*     */       
/* 149 */       add((SPRITE)new SPRITE.Imp(24)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 153 */               WHaven f = (WHaven)UICampList.Button.access$0(UICampList.Button.this).all().get(((Integer)ier.get()).intValue());
/* 154 */               ((f.type()).race.appearance()).icon.render(r, X1, X2, Y1, Y2);
/*     */             }
/* 156 */           }0, 0);
/*     */       
/* 158 */       addRightC(4, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 162 */               WHaven f = (WHaven)UICampList.Button.access$0(UICampList.Button.this).all().get(((Integer)ier.get()).intValue());
/* 163 */               text.setMaxWidth(232);
/* 164 */               text.setMultipleLines(false);
/* 165 */               text.lablify().add((CharSequence)f.name);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 170 */       body().setWidth(276.0D);
/*     */       
/* 172 */       pad(4, 2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 181 */       WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 182 */       (VIEW.world()).window.centererTile.set(f.ctx(), f.cty());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 192 */       GButt.ButtPanel.renderBG(r, true, false, hoveredIs(), (RECTANGLE)body());
/* 193 */       super.render(r, ds);
/* 194 */       WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 195 */       if (f.faction() != FACTIONS.player()) {
/* 196 */         OPACITY.O66.bind();
/* 197 */         COLOR.BLACK.render(r, (RECTANGLE)body(), -2);
/* 198 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 206 */       if (super.hover(mCoo)) {
/* 207 */         WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 208 */         UICampList.this.hBody.moveC((f.ctx() * 64 + 32), (f.cty() * 64 + 32));
/* 209 */         (WORLD.OVERLAY()).things.hover((RECTANGLE)UICampList.this.hBody, GCOLOR.MAP().get(f.faction()), false, 0);
/* 210 */         return true;
/*     */       } 
/*     */       
/* 213 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 218 */       WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 219 */       CampInfo.hover(text, f);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISidePanel get(WHaven f) {
/* 227 */     this.upI = -1;
/*     */ 
/*     */     
/* 230 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, WHaven w) {
/* 235 */     CampInfo.hover(box, w);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\camps\UICampList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */